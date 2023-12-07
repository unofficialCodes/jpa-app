package org.jpa.app.model;

//@Entity
//@Table(name = "students")
//@Cacheable(value = false)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    /*
    primary key - String
    @GeneratedValue(generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDHexGenerator", parameters = @Parameter(name = "separator", value = "-"))
    private String id;

    primary key - UUID
    @GeneratedValue(generator = "uuid_generator")
    @GenericGenerator(name = "uuid_generator", strategy = "org.hibernate.id.UUIDGenerator", parameters = @Parameter(name = "separator", value = "-"))
    private UUID id;
    */
    private int id;
    private String name;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student() {
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
