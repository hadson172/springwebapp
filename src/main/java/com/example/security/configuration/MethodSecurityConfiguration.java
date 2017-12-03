package com.example.security.configuration;

import com.example.rest.utilities.PropertyPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
public class MethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    private PropertyPermissionEvaluator evaluator;

    @Autowired
    public MethodSecurityConfiguration(PropertyPermissionEvaluator evaluator) {
        this.evaluator = evaluator;
    }

//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
//        expressionHandler.setPermissionEvaluator(evaluator);
//        return expressionHandler;
//    }
}
