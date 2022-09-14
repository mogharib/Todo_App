package com.MoAbdelHamied.TodoApp.Security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
 @Document (collection  = "users")
public class AppUser implements UserDetails {

    private String id;

    @NotNull
    private String name ;

    @NotNull
    @JsonIgnore
    private String password ;

     public void setPassword(String password) {
         this.password = password;
     }

     @NotNull
     private String email ;
     private Date created ;

     public AppUser() {
     }

     public AppUser(  @NotNull String name, @NotNull String password, @NotNull String email) {
         this.name = name;
         this.password = password;
         this.email = email;
         this.created = new Date();
     }

     public String getId() {
         return id;
     }

     public void setId(String id) {
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Date getCreated() {
         return created;
     }

     public void setCreated(Date created) {
         this.created = created;
     }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
