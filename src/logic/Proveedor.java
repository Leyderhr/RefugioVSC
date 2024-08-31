package logic;

public class Proveedor {

    private int id_proveedor, provincia;
    private String nombre, direccion, telefono, email;
    private char tipo_proveedor;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String nombre, String direccion, String telefono, String email, int provincia) {
        setId_proveedor(id_proveedor);
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setEmail(email);
        setProvincia(provincia);
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public char getTipo_proveedor() {return tipo_proveedor;}

    public void setTipo_proveedor(char tipo_proveedor) {this.tipo_proveedor = tipo_proveedor;}
}
