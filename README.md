# SecurityWithJWT




 
Controller konfiguratsiyasi


@RestController
public class GreetingController {

    @GetMapping
    public String greeting(HttpServletRequest request) {
        return "Hello World "+request.getSession().getId();
    }



    @GetMapping("/api/v1/admin")
    public String privatePage(){
        return "[~~~~~~~~~~~~~WELCOME TO THE ADMIN PAGE~~~~~~~~~~~~~~~~~]";
    }

    @GetMapping("/api/v1/user")
    public String userPage(){
        return "[~~~~~~~~~~~~~~~~WELCOME TO THE USER PAGE~~~~~~~~~~~~~~]";
    }
}



USER va ADMIN  rolidagi foydalanuvchi uchun ruxsat etilgan yo'l! 
<img width="2560" height="1440" alt="{48FEEDE4-8A5A-404C-B61A-9282295FBBD6}" src="https://github.com/user-attachments/assets/6d771bc7-c86f-4133-9d68-3dfc876849a8" />



                ~~~~~~~~~~~~~~~~~~~~Security konfiguratsiyasi~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        .requestMatchers("/","/api/v1/auth/login").permitAll()
                                        .requestMatchers("/api/v1/auth/register","api/v1/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/api/v1/user/**").hasAnyRole("USER","ADMIN")
                                        .anyRequest().authenticated()
                )
                .sessionManagement(
                        sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }





