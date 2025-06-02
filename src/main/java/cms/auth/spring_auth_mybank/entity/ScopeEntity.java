package cms.auth.spring_auth_mybank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ScopeEntity {
    @Id
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "permission")
    private String permission_state;

    public ScopeEntity() {
    }

    public ScopeEntity(Integer permissionId, String permission_state) {
        this.permissionId = permissionId;
        this.permission_state = permission_state;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermission_state() {
        return permission_state;
    }

    public void setPermission_state(String permission_state) {
        this.permission_state = permission_state;
    }
}
