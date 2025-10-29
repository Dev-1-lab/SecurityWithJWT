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
<img width="2560" height="1389" alt="{4F333D54-0D44-40E8-AC3E-C3B2FE437B10}" src="https://github.com/user-attachments/assets/e05dd3ee-49a0-4736-9ab5-e279b6578bd0" />







