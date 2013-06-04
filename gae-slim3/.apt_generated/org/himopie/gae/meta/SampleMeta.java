package org.himopie.gae.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-06-04 23:20:34")
/** */
public final class SampleMeta extends org.slim3.datastore.ModelMeta<org.himopie.gae.model.Sample> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.himopie.gae.model.Sample> content = new org.slim3.datastore.StringAttributeMeta<org.himopie.gae.model.Sample>(this, "content", "content");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.himopie.gae.model.Sample, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<org.himopie.gae.model.Sample, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.himopie.gae.model.Sample, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<org.himopie.gae.model.Sample, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<org.himopie.gae.model.Sample> title = new org.slim3.datastore.StringAttributeMeta<org.himopie.gae.model.Sample>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<org.himopie.gae.model.Sample, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<org.himopie.gae.model.Sample, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SampleMeta slim3_singleton = new SampleMeta();

    /**
     * @return the singleton
     */
    public static SampleMeta get() {
       return slim3_singleton;
    }

    /** */
    public SampleMeta() {
        super("Sample", org.himopie.gae.model.Sample.class);
    }

    @Override
    public org.himopie.gae.model.Sample entityToModel(com.google.appengine.api.datastore.Entity entity) {
        org.himopie.gae.model.Sample model = new org.himopie.gae.model.Sample();
        model.setContent((java.lang.String) entity.getProperty("content"));
        model.setCreatedDate((java.util.Date) entity.getProperty("createdDate"));
        model.setKey(entity.getKey());
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        org.himopie.gae.model.Sample m = (org.himopie.gae.model.Sample) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("content", m.getContent());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        org.himopie.gae.model.Sample m = (org.himopie.gae.model.Sample) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        org.himopie.gae.model.Sample m = (org.himopie.gae.model.Sample) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        org.himopie.gae.model.Sample m = (org.himopie.gae.model.Sample) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        org.himopie.gae.model.Sample m = (org.himopie.gae.model.Sample) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        org.himopie.gae.model.Sample m = (org.himopie.gae.model.Sample) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder0.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected org.himopie.gae.model.Sample jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        org.himopie.gae.model.Sample m = new org.himopie.gae.model.Sample();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("title");
        m.setTitle(decoder0.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}