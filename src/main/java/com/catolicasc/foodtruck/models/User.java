package com.catolicasc.foodtruck.models;



/**
 * <code>public class User</code><br>
 * classe modelo para usuários do meu banco
 * @author dayanfreitas
 */
public class User {

    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
