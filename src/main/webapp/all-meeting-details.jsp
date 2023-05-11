<%@page import="com.pcsgpl.tc.dto.OfficeLocationsDTO"%>
<%@page import="com.pcsgpl.tc.entity.MeetingCalenderEntity"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import = "org.springframework.security.core.userdetails.UserDetails"%>
<body >

<div align="center">
    <h1>Meeting List</h1>   
    <br/>
	<%@include file="navbar.jsp"%>
	 
	<form action="/search-meeting-by-branch-location?page=0&size=5" method="GET" >
	        <input type="hidden" name="page" value=0 />
            <input type="hidden" name="size" value=5 />
	        <table style="align:center">
	            <tr>
	            <td>
	                <%				         
					   List<OfficeLocationsDTO> officeLocDtos = (List<OfficeLocationsDTO>) request.getAttribute("officeLocDtos");
					%>
					   Search By Branch :      <select name="officelocation" >
						     <% for(OfficeLocationsDTO officeLocationsDTO:officeLocDtos){ 
							  %> 							                    	
								<option value="<%=officeLocationsDTO.getBranchCode()%>"><%=officeLocationsDTO.getBranchName()%></option>
									<%} %>
						        </select>     
	           </td>
	           <td>
	                   <input type="submit" value="Search" />
	          </td>
	        
	           </tr>        
	         </table>
	    </form>
	  
	    <form action="/search-meeting-by-form-date-to-date?page=0&size=5" method="GET">
	        <input type="hidden" name="page" value=0 />
            <input type="hidden" name="size" value=5 />
	        <table style="align:center">
	            <tr>
	            <td>
	                   From Date <input type="date" name="meetingStartDate" required="required"/>
	                    <span> &nbsp;</span>
	                   To Date <input type="date" name="meetingEndDate" required="required"/> 
	           </td>
	           <td>
	                   <input type="submit" value="SearchByDate" />
	          </td>
	        
	           </tr>        
	         </table>
	    </form>
	    

	    
	    <form action="/sort-by-date?page=0&size=5" method="GET">
	          <input type="hidden" name="page" value=0 />
	          <input type="hidden" name="size" value=5 />
	          <table>
	                <tr>
	                   <td>Sort By Start Date</td>
                       <td><input type="submit" value="Sort" /></td>
	                </tr>
	          </table>
	    </form>
	    <form action="/sort-by-location?page=0&size=5" method="GET">
	          <input type="hidden" name="page" value=0 />
              <input type="hidden" name="size" value=5 />
	          <table>
	                <tr>
	                    <td>Sort By Branch</td>	                        
	                    <td><input type="submit" value="Sort" /></td>        	                                       	                               	                               	                                                   
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
                <th>Passcode</th>
                <th>Zoom Url</th>
                              
                <th>Start Date &udarr;</th>
                <th>End Date &udarr;</th>
                <th>Start Time</th>            
                <th>End Time</th>                           
                <th>Branch &udarr;</th>
                <th>Actions</th>  
            </tr>
        </thead>
        <tbody>
        <c:forEach var="calender_info_details" items="${calender_info_details}">
            <tr >
                <td><a href="GetMeetingByMeetingId?meetingId=${calender_info_details.meetingId}" style="text-decoration:none" >${calender_info_details.meetingTitle} </a></td>
                <td>${calender_info_details.meetingShortDesc}</td>            
                <td>${calender_info_details.meetingCategory}</td>
                <td>${calender_info_details.meetingOccuranceType}</td>
                <td>${calender_info_details.meetingId}</td>
                <td>${calender_info_details.meetingPasscode}</td> 
                <td style="display: block;width: 70px;overflow: hidden;text-overflow: ellipsis;">       
                    ${calender_info_details.zoomUrl}</td>
                                
                <td>${calender_info_details.meetingStartDate}</td>
                <td>${calender_info_details.meetingEndDate}</td>
                <td>${calender_info_details.meetingStartTime}&nbsp;${calender_info_details.meetingStartMeridiem}</td>               
                <td>${calender_info_details.meetingEndTime}&nbsp;${calender_info_details.meetingEndMeridiem}</td>         

                <td>${calender_info_details.meetingBranch}</td>                               
                <td>
                    <a href="GetMeetingByMeetingId?meetingId=${calender_info_details.meetingId}" style="text-decoration:none" >View</a> 
                    <% 
                UserDetails userSession1 = (UserDetails) session.getAttribute("User_Session");
                System.out.println("User Name in NavBar: "+ userSession.getUsername());
                
                if(userSession1.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equalsIgnoreCase("Admin"))){
                
              %>              
                    <a href="edit-meeting?meetingId=${calender_info_details.meetingId}" style="text-decoration:none">Edit</a> 
                    <a href="delete-meeting?meetingId=${calender_info_details.meetingId}" style="text-decoration:none">Delete</a>  
                     <%
                }
              %>                   
                </td>
            </tr>          
            </c:forEach>  
        </tbody>   
    </table>


    <c:if test="${calender_info_details.size() > 0}">
		<div align="left">
		    <c:choose>
                <c:when test="${totalElements lt number*pageSize+1+pageSize}">
                Showing ${number*pageSize+1} to ${totalElements} of ${totalElements}
                </c:when>
                <c:otherwise>
                Showing ${number*pageSize+1} to ${number*pageSize+pageSize} of ${totalElements}
                </c:otherwise>
            </c:choose>
			<ul style="margin:5px;">
				<c:forEach begin="0" end="${totalPages-1}" var="pagoda">
					<li>
					    <c:choose>
					        <c:when test="${API eq 'sort-by-date'}">
                              <a href="sort-by-date?page=${pagoda}&size=${pageSize}">${pagoda+1}</a>
                            </c:when>
                            <c:when test="${API eq 'sort-by-location'}">
                              <a href="sort-by-location?page=${pagoda}&size=${pageSize}">${pagoda+1}</a>
                            </c:when>
                            <c:when test="${API eq 'search-meeting-by-branch-location'}">
                              <a href="search-meeting-by-branch-location?page=${pagoda}&size=${pageSize}&branchName=${branchName}">${pagoda+1}</a>
                            </c:when>
                            <c:when test="${API eq 'search-meeting-by-form-date-to-date'}">
                              <a href="search-meeting-by-form-date-to-date?page=${pagoda}&size=${pageSize}">${pagoda+1}</a>
                            </c:when>
                            <c:otherwise>
                              <a href="GetAllMeetingDetails?page=${pagoda}&size=${pageSize}">${pagoda+1}</a>
                            </c:otherwise>
                        </c:choose>

					</li>
				</c:forEach>
			</ul>
		</div>
    </c:if>




<%@include file="footer.jsp"%>  
</body>
