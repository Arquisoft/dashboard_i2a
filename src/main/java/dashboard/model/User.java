package dashboard.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Id
    private String dni;
    private String nombre;
    private String apellidos;
    private String password;
    private String email;
    private java.sql.Date nacimiento;
    private String direccion;
    private String nacionalidad;
    private Long polling;

    @OneToMany(mappedBy = "user_id")
    private Set<Proposal> proposals = new HashSet<>();

    @OneToMany private Set<Commentary> commentaries = new HashSet<>();

    Set<Commentary> _getCommentaries() {
        return commentaries;
    }

    Set<Proposal> _getProposals() {
        return proposals;
    }

    public User(String dni, String nombre, String apellidos, String password, String email, Date nacimiento,
              String direccion, String nacionalidad, Long polling) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.email = email;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.polling = polling;
    }

    protected User(){}

    public Set<Proposal> getProposals() {
      return new HashSet<>(proposals);
    }
    public Set<Commentary> getCommentaries() {
        return new HashSet<>(commentaries);
    }
    public Long getId() {
    return id;
    }

    public String getDni() {
    return dni;
    }

    public void setDni(String dni) {
    this.dni = dni;
    }

    public String getNombre() {
    return nombre;
    }

    public void setNombre(String nombre) {
    this.nombre = nombre;
    }

    public String getApellidos() {
    return apellidos;
    }

    public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
    }

    public String getPassword() {
    return password;
    }

    public void setPassword(String password) {
    this.password = password;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public java.sql.Date getNacimiento() {
    return nacimiento;
    }

    public void setNacimiento(java.sql.Date nacimiento) {
    this.nacimiento = nacimiento;
    }

    public String getDireccion() {
    return direccion;
    }

    public void setDireccion(String direccion) {
    this.direccion = direccion;
    }

    public String getNacionalidad() {
    return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
    }

    public Long getPolling() {
    return polling;
    }

    public void setPolling(Long polling) {
    this.polling = polling;
    }

    @Override
    public String toString() {
    return "User{" +
            "id=" + id +
            ", dni='" + dni + '\'' +
            ", nombre='" + nombre + '\'' +
            ", apellidos='" + apellidos + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", nacimiento=" + nacimiento +
            ", direccion='" + direccion + '\'' +
            ", nacionalidad='" + nacionalidad + '\'' +
            ", polling=" + polling +
            '}';
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(dni, user.dni) &&
            Objects.equals(nombre, user.nombre) &&
            Objects.equals(apellidos, user.apellidos) &&
            Objects.equals(password, user.password) &&
            Objects.equals(email, user.email) &&
            Objects.equals(nacimiento, user.nacimiento) &&
            Objects.equals(direccion, user.direccion) &&
            Objects.equals(nacionalidad, user.nacionalidad) &&
            Objects.equals(polling, user.polling);
    }

    @Override
    public int hashCode() {
    return Objects.hash(id, dni, nombre, apellidos, password, email, nacimiento, direccion, nacionalidad, polling);
    }
}
