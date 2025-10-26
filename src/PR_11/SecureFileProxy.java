package PR_11;

import java.util.*;
import java.io.*;

public class SecureFileProxy implements FileAccess {
    private RealFileAccess realFileAccess;
    private Map<String, Set<String>> filePermissions;
    private Map<String, Set<String>> userRoles;
    private Map<String, Set<String>> rolePermissions;

    public SecureFileProxy() {
        this.realFileAccess = new RealFileAccess();
        this.filePermissions = new HashMap<>();
        this.userRoles = new HashMap<>();
        this.rolePermissions = new HashMap<>();

        initializePermissions();
    }

    private void initializePermissions() {
        Set<String> adminRoles = new HashSet<>(List.of("read", "write", "delete"));
        Set<String> userRoles = new HashSet<>(List.of("read", "write"));
        Set<String> guestRoles = new HashSet<>(List.of("read"));

        rolePermissions.put("admin", adminRoles);
        rolePermissions.put("user", userRoles);
        rolePermissions.put("guest", guestRoles);

        this.userRoles.put("alice", new HashSet<>(List.of("admin")));
        this.userRoles.put("bob", new HashSet<>(List.of("user")));
        this.userRoles.put("guest", new HashSet<>(List.of("guest")));

        filePermissions.put("public.txt", new HashSet<>(List.of("alice", "bob", "guest")));
        filePermissions.put("confidential.pdf", new HashSet<>(List.of("alice", "bob")));
        filePermissions.put("secret.txt", new HashSet<>(List.of("alice")));
    }

    @Override
    public void open(String filename, String user) {
        if (!hasAccess(filename, user)) {
            System.out.println("ОШИБКА: Пользователь " + user + " не имеет доступа к файлу '" + filename + "'");
            return;
        }
        realFileAccess.open(filename, user);
    }

    @Override
    public void read(String filename, String user) {
        if (!hasPermission(filename, user, "read")) {
            System.out.println("ОШИБКА: Пользователь " + user + " не имеет права чтения файла '" + filename + "'");
            return;
        }
        realFileAccess.read(filename, user);
    }

    @Override
    public void write(String filename, String user) {
        if (!hasPermission(filename, user, "write")) {
            System.out.println("ОШИБКА: Пользователь " + user + " не имеет права записи в файл '" + filename + "'");
            return;
        }
        realFileAccess.write(filename, user);
    }

    @Override
    public void delete(String filename, String user) {
        if (!hasPermission(filename, user, "delete")) {
            System.out.println("ОШИБКА: Пользователь " + user + " не имеет права удаления файла '" + filename + "'");
            return;
        }
        realFileAccess.delete(filename, user);
    }

    private boolean hasAccess(String filename, String user) {
        return filePermissions.containsKey(filename) &&
                filePermissions.get(filename).contains(user);
    }

    private boolean hasPermission(String filename, String user, String permission) {
        if (!hasAccess(filename, user)) {
            return false;
        }

        Set<String> roles = userRoles.get(user);
        if (roles == null) return false;

        for (String role : roles) {
            Set<String> permissions = rolePermissions.get(role);
            if (permissions != null && permissions.contains(permission)) {
                return true;
            }
        }
        return false;
    }

    public void grantAccess(String filename, String user) {
        filePermissions.computeIfAbsent(filename, k -> new HashSet<>()).add(user);
        System.out.println("Пользователю " + user + " предоставлен доступ к файлу '" + filename + "'");
    }

    public void revokeAccess(String filename, String user) {
        if (filePermissions.containsKey(filename)) {
            filePermissions.get(filename).remove(user);
            System.out.println("Доступ пользователя " + user + " к файлу '" + filename + "' отозван");
        }
    }
}
