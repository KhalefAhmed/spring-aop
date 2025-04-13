package me.akhalef.service;

public class SecurityContext {
    public static String username;
    public static String password;
    public static String[] roles;

    public static void authenticate(String user, String pass, String[] userRoles) {
        if (user.equals("root") && pass.equals("root")) {
            roles = userRoles;
            username = user;
            password = pass;
        } else {
            throw new SecurityException("Invalid credentials");
        }
    }

    public static boolean hasRole(String role) {
        for (String r : roles) {
            if (r.equals(role)) {
                return true;
            }
        }
        return false;
    }
}
