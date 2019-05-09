package ru.sydev.rolehierarchy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties("security.role")
public class SecurityRoleHierarchyExtension
{
    private String hierarchy;
}
