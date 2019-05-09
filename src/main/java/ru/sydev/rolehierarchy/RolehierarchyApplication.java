package ru.sydev.rolehierarchy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@SpringBootApplication
@EnableConfigurationProperties(SecurityRoleHierarchyExtension.class)
public class RolehierarchyApplication {

	public static void main(String[] args) {
        RoleHierarchy roleHierarchy = SpringApplication.run(RolehierarchyApplication.class, args).getBean( RoleHierarchy.class );

        String role1 = "client-create";
        String role2 = "create";

        System.out.printf("Tree 1 role: %s implies: %s%n",
            role1,
            roleHierarchy.getReachableGrantedAuthorities( createAuthorityList( role1 ) )
        );

        System.out.printf("Tree 2 role: %s implies: %s%n",
            role2,
            roleHierarchy.getReachableGrantedAuthorities( createAuthorityList( role2 ) )
        );
	}

    @Bean
    RoleHierarchy roleHierarchy(SecurityRoleHierarchyExtension securityRoleHierarchyExtension) {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy( securityRoleHierarchyExtension.getHierarchy() );

        return roleHierarchy;
    }

}
