package com.etiya.crmlite.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CDATE")
    private LocalDateTime cDate;

    @Column(name = "UDATE")
    private LocalDateTime uDate;

    @Column(name = "UUSER")
    private Long uUser;

    @Column(name = "CUSER")
    private Long cUser;

    @PrePersist
    public void onCreate() {
        this.cUser = 10L;
        this.cDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.uUser = 10L;
        this.uDate = LocalDateTime.now();
    }
}
