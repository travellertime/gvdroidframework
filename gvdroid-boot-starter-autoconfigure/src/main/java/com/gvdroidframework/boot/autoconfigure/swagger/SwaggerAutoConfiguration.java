package com.gvdroidframework.boot.autoconfigure.swagger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.web.Swagger2Controller;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Swagger启动配置类
 *
 * @author Colin
 * @version 5.0.0
 * @since 2.0.0
 */
@Configuration
@ConditionalOnClass(Swagger2Controller.class)
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "gvdroid.swagger", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(SwaggerProperties.class)
@EnableSwagger2
public class SwaggerAutoConfiguration implements InitializingBean {

    SwaggerProperties swaggerProperties;

    public SwaggerAutoConfiguration(SwaggerProperties swaggerProperties) {
        this.swaggerProperties = swaggerProperties;
        this.afterPropertiesSet();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.title)
                .description(swaggerProperties.description)
                .license(swaggerProperties.license)
                /*.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("http://")
                .contact(new Contact("","", "you@your-company.com"))*/
                .version(swaggerProperties.version)
                .build();
    }

    @Bean
    public Docket customImplementation() {
        // Docket, Springfox’s, primary api config mechanism is initialized for swagger specification 2.0
        return new Docket(DocumentationType.SWAGGER_2)
                // select() returns an instance of ApiSelectorBuilder to give fine grained control over the endpoints exposed via swagger.
                .select()
                // allows selection of RequestHandler's using a predicate.
                // Out of the box predicates provided are any, none, withClassAnnotation, withMethodAnnotation and basePackage.
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.basePackage))
                // allows selection of Path's using a predicate.
                // The example here uses an any predicate (default)
                .paths(PathSelectors.any())
                // The selector requires to be built after configuring the api and path selectors.
                .build()
                // Convenience rule buildInsert substitutes LocalDate with String when rendering model properties
                // Convenience rule buildInsert that substitutes a generic type with one type parameter with the type parameter.
                // In this example ResponseEntity<T> with T. alternateTypeRules
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(OffsetDateTime.class, Date.class)
                .apiInfo(apiInfo());
    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.swaggerProperties.getBasePackage(), "gvdroid.swagger.basePackage cannot be null.");
    }
}
