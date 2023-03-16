<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body >
<!--  <body style="color: #fff;
    background: -webkit-linear-gradient(110deg, #86AAF2 40%, rgba(0, 0, 0, 0) 30%), -webkit-radial-gradient(farthest-corner at 0% 0%,#4884FA 70%, #2F6FED 70%);
    background: -o-linear-gradient(110deg, #86AAF2 40%, rgba(0, 0, 0, 0) 30%), -o-radial-gradient(farthest-corner at 0% 0%, #4884FA 70%, #2F6FED 70%);
    background: -moz-linear-gradient(110deg, #86AAF2 40%, rgba(0, 0, 0, 0) 30%), -moz-radial-gradient(farthest-corner at 0% 0%, #4884FA 70%, #2F6FED 70%);
    background: linear-gradient(110deg, #86AAF2 40%, rgba(0, 0, 0, 0) 30%), radial-gradient(farthest-corner at 0% 0%,#4884FA 70%,#2F6FED  70%);"
    >  -->
<div align="center">
    <h1>Meeting List</h1>   
    <br/><br/>
	<%@include file="navbar.jsp"%>
	 
	<form th:action="@{/}">
	        <table style="align:center">
	            <tr>
	            <td>
	        Filter: <input type="text" name="keyword" id="keyword" size="50"  required />
	           </td>
	           <td>
	                   <input type="submit" value="Search" />
	          </td>
	          <td>         
	           
	                   <input type="reset" name="Reset" value="Clear" />
	           </td>
	           </tr>        
	         </table>
	    </form>
	    <% if(request.getAttribute("delete-message") != null){ %>
	               <%=request.getAttribute("delete-message")%>
	    <%}%>
    <table style="border-spacing:0;" border="1">	 
        <thead>          
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Category</th>
                <th>Occurance Type</th>
                <th>Meeting Id</th>
                <th>Zoom Url</th>
                <th>Passcode</th>              
                <th>Start Date</th>
                <th>End Date</th>
                <th>Start Time</th>            
                <th>End Time</th>                           
                <th>Branch</th>
                <th>Actions</th>  
            </tr>
        </thead>
        <tbody>
        <c:forEach var="calender_info_details" items="${calender_info_detailss}">
            <tr >
                <td><a href="GetMeetingByMeetingId?meetingId=${calender_info_details.meetingId}" style="text-decoration:none" >${calender_info_details.meetingTitle} </a></td>
                <td>${calender_info_details.meetingShortDesc}</td>            
                <td>${calender_info_details.meetingCategory}</td>
                <td>${calender_info_details.meetingOccuranceType}</td>
                <td>${calender_info_details.meetingId}</td>
                <td>${calender_info_details.zoomUrl}</td>
                <td>${calender_info_details.meetingPasscode}</td>                 
                <td>${calender_info_details.meetingStartDate}</td>
                <td>${calender_info_details.meetingEndDate}</td>
                <td>${calender_info_details.meetingStartTime}&nbsp;${calender_info_details.meetingStartMeridiem}</td>               
                <td>${calender_info_details.meetingEndTime}&nbsp;${calender_info_details.meetingEndMeridiem}</td>         

                <td>${calender_info_details.meetingBranch}</td>                               
                <td>
                    <a href="GetMeetingByMeetingId?meetingId=${calender_info_details.meetingId}" style="text-decoration:none" >View</a>               
                    <a href="edit-meeting?meetingId=${calender_info_details.meetingId}" style="text-decoration:none">Edit</a> 
                    <a href="delete-meeting?meetingId=${calender_info_details.meetingId}" style="text-decoration:none">Delete</a>                     
                </td>
            </tr>
            </c:forEach>  
        </tbody>   
    </table>
</div> 
<%@include file="footer.jsp"%>  
</body>
