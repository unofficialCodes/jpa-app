## Life Cycle of Entity : 
* Entity has life cycle methods
```                       
                        detach -> em.detach(entity)
 Entity -> transient ->     managed (persistent)    -> database
                        removal -> em.remove(entity)
```
### Loading :
* PostLoad - `@PostLoad` 

### Pre entity actions :
* PrePersist - `@PrePersist`
* PreUpdate - `@PreUpdate`
* PreRemove - `@PreRemove`

### Post entity actions :
* PostPersist - `@PostPersist`
* PostUpdate - `@PostUpdate`
* PostRemove - `@PostRemove`

### Detach State : 
* entityManager.detach(entity)

1. After an entity has been created, it will be in transient state.
2. The entities are managed by the Persistence context 
3. Once the entity's remove method is called, this entity will be in removal state.
4. Detach state, either the entity is no longer useful or the in-built EntityManager.detach(entity) is invoked and the entity will not be managed by the persistence context.

- **GenerationType.IDENTITY** 
 Auto increments values from database 
- **GenerationType.SEQUENCE** 
 This is a database specific type, where sequences are allowed by the database.
- **GenerationType.TABLE** 
 A table will be created for storing the sequence name (primary key) and value counter column (value column) 
- **GenerationType.AUTO**
 JPA automatically picks the generation type that is supported by the database.
- **GenerationType.UUID** 
 generates UUIDs for the id column in the database. 