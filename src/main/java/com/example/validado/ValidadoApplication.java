    package com.example.validado;

    import com.example.validado.ui.LoginView;

    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.context.annotation.Bean;
    import com.vaadin.flow.spring.security.VaadinWebSecurity;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;

    @SpringBootApplication
    public class ValidadoApplication extends VaadinWebSecurity {

        public static void main(String[] args) {

            SpringApplication.run(ValidadoApplication.class, args);
        }


    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new InMemoryUserDetailsManager(
                User.withUsername("Brenda")
                        .password("{noop}teste")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("Andreia")
                        .password("{noop}teste")
                        .roles("ADMIN")
                        .build()

        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LoginView.class);
    }
}


