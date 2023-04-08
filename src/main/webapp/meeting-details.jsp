
<%@page import="com.pcsgpl.tc.dto.MeetingCalenderDTO"%>
<body>

	<%@include file="header.jsp"%>
	<%@include file="navbar.jsp"%>
	<div align="center">
		<form action="/meeting-registration" method="post">
			<fieldset style="width: 600px; align: center">
				<legend> Meeting Registration Window</legend>				
				     <%				     
				         if(request.getAttribute("calender_info_by_meeting_id")!=null){				        	 
				        	 MeetingCalenderDTO  meetingCalenderDTO  =(MeetingCalenderDTO) request.getAttribute("calender_info_by_meeting_id");				        	 				        	 
				      %>				        	  				        													
				      <table style="align: center; width: 100%" border="0">
					  					        
					        <tr>
					             <td><label for="meetingCategory">Category </label></td>
						         <td><%=meetingCalenderDTO.getMeetingCategory()%></td>  						          						        						        							        								    							     
					        </tr>
					         
					        <tr>
						         <td><label for="meetingOccuranceType">Meeting Occurance Type</label></td>						            						            						         
						         <td><%=meetingCalenderDTO.getMeetingOccuranceType()%></td>						           							     
					        </tr>

							<tr>
								 <td><label for="meetingStartDate">Start Date</label></td>								      									  								  
								 <td><%=meetingCalenderDTO.getMeetingStartDate()%></td>								     								  
							</tr>

							<tr>
								<td><label for="meetingEndDate">End Date</label></td>								    								    								
								<td><%=meetingCalenderDTO.getMeetingEndDate()%></td>								   								
							</tr>

							<tr>
								 <td><label for="meetingStartTime">Start Time</label></td>
								 <td><%=meetingCalenderDTO.getMeetingStartTime()%><%=meetingCalenderDTO.getMeetingStartMeridiem()%></td>    								  
							</tr>

							<tr>
								 <td><label for="meetingEndTime">End Time</label></td>
								 <td><%=meetingCalenderDTO.getMeetingEndTime()%><%=meetingCalenderDTO.getMeetingEndMeridiem()%></td>  
							</tr>		   																																			

							<tr>
								 <td><label for="meetingTitle">Title</label></td>
								 <td><%=meetingCalenderDTO.getMeetingTitle()%></td>	    
							</tr>		  

							<tr>
								<td><label for="meetingShortDesc">Description</label></td>
								<td><%=meetingCalenderDTO.getMeetingShortDesc()%></td>
							</tr>
								
							<tr>
								 <td><label for="meetingBranch">Branch</label></td>
								 <td><%=meetingCalenderDTO.getMeetingBranch()%></td>
							</tr>
								
							<tr>
								 <td><label for="meetingId">Zoom Meeting Id</label></td>
								 <td><%=meetingCalenderDTO.getMeetingId()%></td>			
							</tr>
								
							<tr>
								<td><label for="meetingPasscode">Zoom Meeting Passcode</label></td>
								<td><%=meetingCalenderDTO.getMeetingPasscode()%></td>
							</tr>
								
							<tr>
								 <td><label for="zoomUrl">Zoom Meeting URL</label></td>
                                 <td><%=meetingCalenderDTO.getZoomUrl()%></td>
						    </tr>
								
							
							<%
				         }				     				     				     
				     %>
				
				  </table>
			</fieldset>
		</form>
	</div>
<%@include file="footer.jsp"%>
</body>
