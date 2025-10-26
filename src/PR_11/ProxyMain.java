package PR_11;

// Демонстрационный класс
public class ProxyMain {
    public static void main(String[] args) {
        SecureFileProxy fileProxy = new SecureFileProxy();

        System.out.println("=== Тестирование доступа к файлам ===\n");

        System.out.println("--- Alice (admin) ---");
        fileProxy.open("public.txt", "alice");
        fileProxy.read("public.txt", "alice");
        fileProxy.write("public.txt", "alice");
        fileProxy.delete("public.txt", "alice");

        System.out.println("\n--- Alice пытается получить доступ к secret.txt ---");
        fileProxy.open("secret.txt", "alice");
        fileProxy.read("secret.txt", "alice");

        System.out.println("\n--- Bob (user) ---");
        fileProxy.open("confidential.pdf", "bob");
        fileProxy.read("confidential.pdf", "bob");
        fileProxy.write("confidential.pdf", "bob");
        fileProxy.delete("confidential.pdf", "bob");

        System.out.println("\n--- Guest ---");
        fileProxy.open("public.txt", "guest");
        fileProxy.read("public.txt", "guest");
        fileProxy.write("public.txt", "guest");

        System.out.println("\n--- Попытка несанкционированного доступа ---");
        fileProxy.open("secret.txt", "bob");
        fileProxy.open("nonexistent.txt", "alice");

        System.out.println("\n--- Динамическое изменение прав ---");
        fileProxy.grantAccess("secret.txt", "bob");
        fileProxy.open("secret.txt", "bob");
        fileProxy.read("secret.txt", "bob");
    }
}