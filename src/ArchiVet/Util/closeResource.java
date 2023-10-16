package ArchiVet.Util;

public class closeResource {

    public void closeResource(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception ex) {
                System.err.println("Error al cerrar recurso: " + ex.getMessage());
            }
        }
    }
}
