## Mapping of entity to the database 

1. **XML based mapping** 
- There can be multiple mapping files in a single application

- By default, JPA will search for orm.xml, if not you can name it anything <br>

> META-INF/orm.xml <br> 
> META-INF/myMapping.xml <br>
> META-INF/entity-mapping.xml

Below tag should be included in the persistence.xml, to map entities through xml files

```
<persistence>
    <persistence-unit>
    <mapping-file>META-INF\entity-mapping.xml</mapping-file>
    </persistence-unit>
</persistence>
```

2. **Annotation based mapping**

> @Entity <br>
> @Table <br> 
> @Id <br>
> @Column <br>

- All the mapped entity classes should be included in the persistence.xml file with the below tag

```
<persistence>
    <persistence-unit>
    <class name="org.jpa.app.entityMappings.AnnotatedEntity" />
    <properties>
        <property name="packagesToScan" value="org.jpa.app.entityMappings"/>
    </properties>
    </persistence-unit>
</persistence>
```

- If we try to persist an entity which has a @OneToOne relation with other entity, 
 then the referenced object may not be in the context. we can mention the CascadeType.PERSIST (while persisting only) to persist in the database.
- CascadeType.ALL (cascades all operations of the context)