/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Facade;
import entity.Role;
import entity.User;
import javax.persistence.Persistence;

/**
 *
 * @author malik
 */
public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.addEntityManagerFactory(Persistence.createEntityManagerFactory("persistence"));
        //Create user, works
//        Role userRole = new Role("user");
//        User user = new User("user", "userpass");
//        user.addRole(userRole);
//        System.out.println("CreateUser: " + facade.createUser(user));
//
//        Role adminRole = new Role("admin");
//        User admin = new User("admin", "testadmin");
//        admin.addRole(adminRole);
//        System.out.println("CreateAdmin: " + facade.createUser(admin));
        
        
        //finding a user, works, but only if the code above is not commented out??
        //System.out.println("FindingCustomer1: " + facade.findUser(1));
        User user = facade.findUser(1);
        System.out.println("PW: " + user.getPassword());
        System.out.println("Testing user with OK password: " + user.verifyPassword("userpass"));
        
        
//        User user = facade.getEntityManager().find(User.class, "user");
//        System.out.println("PW: " + user.getPassword());
//        System.out.println("Testing user with OK password: " + user.verifyPassword("testuser"));
////    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
//        System.out.println("Created TEST Users");
    }
}
