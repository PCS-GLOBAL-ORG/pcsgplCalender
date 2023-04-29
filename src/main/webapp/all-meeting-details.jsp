<%@page import="com.pcsgpl.tc.dto.OfficeLocationsDTO"%>
<%@page import="com.pcsgpl.tc.entity.MeetingCalenderEntity"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body >

<div align="center">
    <h1>Meeting List</h1>   
    <br/>
	<%@include file="navbar.jsp"%>
	 
	<form action="/search-meeting-by-branch-location" method="post" >
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
	  
	    <form action="/search-meeting-by-form-date-to-date" method="post">
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
	    
	    <form action="/sort-by-location" method="post">
	          <table>
	                <tr>
	                    <td>Sort By:	                        
	                               <select>	                               
	                                      <option>Select</option>
	                                      <option value="meetingBranch">Branch</option>
	                                      <option value="meetingStartDate">StartDate</option>
	                               </select>	                                       	                               	                               	                               
	                    </td>
	                    <td><input type="submit" value="Sort" /></td>	                    
	                </tr>
	          </table>
	    </form>
	    
	    <form action="/sort-by-date" method="post">
	          <table>
	                <tr>
	                   <td>Sort By Start Date</td>
                       <td><input type="submit" value="Sort" /></td>
	                </tr>
	          </table>
	    </form>
	    <form action="/sort-by-location" method="post">
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
                <th>Zoom Url</th>
                <th>Passcode</th>              
                <th>Start Date &udarr;</th>
                <th>End Date &udarr;</th>
                <th>Start Time</th>            
                <th>End Time</th>                           
                <th>Branch &udarr;</th>
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
                <td style="display: block;width: 70px;overflow: hidden;text-overflow: ellipsis;">       
                    ${calender_info_details.zoomUrl}</td>
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
    
                               <!--  <tr>
									<td>&nbsp;</td>
									<td><input type="submit" name="submit" value="Previous" />
										&nbsp; <input type="reset" name="Reset" value="Next" />
									</td>
								</tr> -->
</div> 

			<%--For displaying Previous link except for the 1st page --%>
<!--  			    <c:if test="${currentPage != 1}">
			        <td><a href="calender_info_details.do?page=${currentPage - 1}">Previous</a></td>
			    </c:if>
			    -->
			 
			    <%--For displaying Page numbers. 
			    The when condition does not display a link for the current page--%>
	<!-- 	    <table border="1" cellpadding="5" cellspacing="5">
			        <tr>
			            <c:forEach begin="1" end="${noOfPages}" var="i">
			                <c:choose>
			                    <c:when test="${currentPage eq i}">
			                        <td>${i}</td>
			                    </c:when>
			                    <c:otherwise>
			                        <td><a href="calender_info_details.do?page=${i}">${i}</a></td>
			                    </c:otherwise>
			                </c:choose>
			            </c:forEach>
			        </tr>
			    </table>
			    <%--For displaying Next link --%>
			    <c:if test="${currentPage lt noOfPages}">
			        <td><a href="calender_info_details.do?page=${currentPage + 1}">Next</a></td>
			    </c:if>
			    -->
<%@include file="footer.jsp"%>  
</body>
