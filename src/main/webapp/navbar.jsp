<%@page import = "org.springframework.security.core.userdetails.UserDetails"%>
    <div align="center">
     <table>
         <tr>
         <td>
              <a href="/" style="text-decoration:none;padding-right:10px;font-size: 20px">Home </a>
              <% 
                UserDetails userSession = (UserDetails) session.getAttribute("User_Session");
                System.out.println("User Name in NavBar: "+ userSession.getUsername());
                
                if(userSession.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equalsIgnoreCase("Admin"))){
                
              %>
              <a href="Schedule-Meeting" style="text-decoration:none;padding-right:10px;font-size: 20px"> Schedule Training</a>

              
              <%
                }
              %>
              <a href="GetAllMeetingDetails?page=0&size=5" style="text-decoration:none;padding-right:10px;font-size: 20px" > View All Trainings</a>

             
              <a href="logout" style="text-decoration:none;padding-right:10px;font-size: 20px" > Logout</a>
                    
         </td>
         </tr>
      </table>
     </div>