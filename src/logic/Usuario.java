package logic;

public class Usuario {
    private String nombre;
    private String contrasegna;
    private int rol;

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Usuario(){}

    public Usuario(String nombre, String contrasegna, int rol) {
        setNombre(nombre);
        setContrasegna(contrasegna);
        setRol(rol);
    }

    public Usuario(String nombre, String contrasegna) {
        setNombre(nombre);
        setContrasegna(contrasegna);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasegna() {
        return contrasegna;
    }

    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }



    @Override
    public boolean equals(Object user){
       return ((Usuario) user).getNombre().equals(this.nombre) && ((Usuario) user).getContrasegna().equals(this.contrasegna);

    }
}
