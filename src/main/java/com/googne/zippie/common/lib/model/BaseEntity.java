package com.googne.zippie.common.lib.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * BaseEntity for Portal Application
 * Supports:
 * - Auditing: createdAt, updatedAt, createdBy, updatedBy
 * - Soft delete: deletedAt, isActive
 * - Optimistic locking: version
 * <p>
 * All entities in the portal should extend this.
 */

@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@MappedSuperclass
public abstract class BaseEntity extends BaseAuditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column
    @Setter
    private String updatedBy;

    @Column
    private Instant deletedAt;

    @Column(nullable = false)
    private boolean isActive = true;

    @Version
    private Long version;

    public void markDeleted(String user) {
        this.deletedAt = Instant.now();
        this.isActive = false;
        this.updatedBy = user;
    }

    public boolean isDeleted() {
        return !isActive;
    }

    /**
     * Utility method to get createdAt in any timezone
     */
    public LocalDateTime getCreatedAtInZone(ZoneId zone) {
        return LocalDateTime.ofInstant(createdAt, zone);
    }

    /**
     * Utility method to get updatedAt in any timezone
     */
    public LocalDateTime getUpdatedAtInZone(ZoneId zone) {
        return LocalDateTime.ofInstant(updatedAt, zone);
    }

    /**
     * Example convenience method for IST
     */
    public LocalDateTime getCreatedAtIST() {
        return getCreatedAtInZone(ZoneId.of("Asia/Kolkata"));
    }

    public LocalDateTime getUpdatedAtIST() {
        return getUpdatedAtInZone(ZoneId.of("Asia/Kolkata"));
    }
}