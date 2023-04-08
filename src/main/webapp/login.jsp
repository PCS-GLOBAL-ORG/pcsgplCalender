<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 ${SPRING_SECURITY_LAST_EXCEPTION.message}
 <fieldset>
     <legend>>  Login To Training Calender App</legend>  
   <form action="login" method="post">
      <table align="center">
         <tr>
            <td> User: </td>
            <td> <input type="text" name="username" value=""></td>
         </tr>
          <tr>
            <td> Password: </td>
            <td> <input type="password" name="password" value=""></td>
         </tr>
          <tr>
            <td> <input type="submit" name="submit" value="Submit"></td>
            <td> <input type="reset" name="reset" value="Reset"></td>
         </tr>
      </table>
   
   
   </form>
</fieldset>

</body>
</html>