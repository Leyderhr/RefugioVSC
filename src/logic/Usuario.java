package logic;

public class Usuario {
    private String nombre;
    private String contrasegna;

    public Usuario(){}

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
