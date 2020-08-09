package cn.zjm404.demo.di;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class MyBeanDefinition {
    private String id;
    private String className;
    private List<Property> properties = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;


    public MyBeanDefinition (String id,String className){
        this.id = id;
        this.className = className;
    }
    public boolean isSingleton(){
        return this.scope.equals(Scope.SINGLETON);
    }
    public boolean isLazyInit(){
        return this.lazyInit;
    }
    public void addProperty(Property property){
        this.properties.add(property);
    }
    public static enum Scope{
        SINGLETON,
        PROTOTYPE
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Property{
        private String name;
        private boolean isList;
        private List<String> refs;
        private String ref;

        public Property(Builder builder) {
            this.name = builder.name;
            this.isList = builder.isList;
            this.ref = builder.ref;
            this.refs = builder.refs;
        }


        @Getter
        public static class Builder{
            private String name;
            private boolean isList;
            private List<String> refs;
            private String ref;

            public Builder setName(String name){
                this.name = name;
                return this;
            }
            public Builder setRefs(List<String> refs){
                this.refs = refs;
                return this;
            }
            public Builder setRef(String ref){
                this.ref = ref;
                return this;
            }

            public Property build(){
                if(this.isList){
                    if(this.ref != null){
                        throw new IllegalArgumentException("当为list时，不需要设置ref");
                    }

                }else{
                    if(this.ref == null){
                        throw new IllegalArgumentException("当不为list时，请设置ref");
                    }
                }
                return new Property(this);
            }
        }
    }

}
