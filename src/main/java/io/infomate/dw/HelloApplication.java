package io.infomate.dw;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.infomate.dw.config.HelloConfig;
import io.infomate.dw.resources.HelloResource;

public class HelloApplication extends Application<HelloConfig> {

  public static void main(String[] args) throws Exception {
    new HelloApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-world";
  }

  @Override
  public void initialize(Bootstrap<HelloConfig> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(HelloConfig configuration, Environment environment) {

    final HelloResource resource = new HelloResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
    );

    environment.jersey().register(resource);

  }
}