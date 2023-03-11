
<%@page import="com.pcsgpl.tc.dto.MeetingCalenderDTO"%>

<!--  --><body bgcolor="#366FE1">
<body style="color: #fff;
    background: -webkit-linear-gradient(110deg, #3366ff 29%, rgba(0, 0, 0, 0) 29%), -webkit-linear-gradient(110deg,#4884FA 66%, #86AAF2 66%);
    background: -o-linear-gradient(110deg, #3366ff 29%, rgba(0, 0, 0, 0) 29%), -o-linear-gradient(110deg,#4884FA 66%, #86AAF2 66%);
    background: -moz-linear-gradient(110deg, #3366ff 29%, rgba(0, 0, 0, 0) 29%), -moz-linear-gradient(110deg,#4884FA 66%, #86AAF2 66%);
    background: linear-gradient(110deg, #3366ff 29%, rgba(0, 0, 0, 0) 29%), linear-gradient(110deg, #4884FA 66% ,#86AAF2 66%);
">
	<%@include file="header.jsp"%>
	<%@include file="navbar.jsp"%>
	<div align="center">
		<form action="/meeting-registration" method="post">
			<fieldset style="width: 600px; align: center">
				<legend> Meeting Registration Window</legend>				
				     <%	
				     OfficeLocationsEntity officeLocationsEntity =
				         if(request.getAttribute("calender_info_by_meeting_id")!=null){				        	 
				        	 MeetingCalenderDTO  meetingCalenderDTO  =(MeetingCalenderDTO) request.getAttribute("calender_info_by_meeting_id");				        	 				        	 
				      %>
				      			        	  				        													
				      <table style="align: center; width: 100%" border="0">
					  					        
					        <tr>
					             <td><label for="meetingCategory">Category </label><font style="color: red">*</font></td>
						         <td>
						             
						             <select name="meetingCategory" required="required">
						                    <option value=""><%=meetingCalenderDTO.getMeetingCategory()%></option>
											<option value="Global">Global</option>
											<option value="Kolkata">Kolkata</option>
											<option value="BTM">BTM Layout</option>
											<option value="Mahadevpura">Mahadevpura</option>
											<option value="BBS">Bhubaneswar</option>
						             </select>     
						         </td>  						          						        						        							        								    							     
					        </tr>
					         
					        <tr>
						         <td>
						              <label for="meetingOccuranceType">Meeting Occurance Type</label>
						              <font style="color: red">*</font>
						         </td>	
						         <td>
								      <% if(meetingCalenderDTO.getMeetingOccuranceType().equals("Multiple")){ %>					            						            						         
								        <input type="radio" name="meetingOccuranceType" checked="checked"/> Multiple
								        <input type="radio" name="meetingOccuranceType" /> Single
								      <%}else if(meetingCalenderDTO.getMeetingOccuranceType().equals("Single")){ %>	
								        <input type="radio" name="meetingOccuranceType" /> Multiple		
								        <input type="radio" name="meetingOccuranceType" checked="checked"/> Single 
								       <%} %>	
						         </td>	           							     
					        </tr>

							<tr>
								 <td>
								     <label for="meetingStartDate">Start Date</label>
								     <font style="color: red">*</font>
								 </td>								      									  								  
								 <td>
									 <%=meetingCalenderDTO.getMeetingStartDate()%>
									 <input type="date" pattern="yyyy-MM-dd" name="meetingStartDate">
								 </td>								     								  
							</tr>

							<tr>
								<td><label for="meetingEndDate">End Date</label><font style="color: red">*</font></td>								    								    								
								<td>
								    <%=meetingCalenderDTO.getMeetingEndDate()%>
								    <input type="date" pattern="yyyy-MM-dd" name="meetingStartDate">
								</td>								   								
							</tr>

							<tr>
								 <td><label for="meetingStartTime">Start Time</label><font style="color: red">*</font></td>
								 <td>
								    
								    <select name="meetingStartTime" required="required">
											<option value=""><%=meetingCalenderDTO.getMeetingStartTime()%></option>
											<option value="12:00">12:00</option>
											<option value="12:30">12:30</option>
											<option value="1:00">1:00</option>
											<option value="1:30">1:30</option>
											<option value="2:00">2:00</option>
											<option value="2:30">2:30</option>
											<option value="3:00">3:00</option>
											<option value="3:30">3:30</option>
											<option value="4:00">4:00</option>
											<option value="4:30">4:30</option>
											<option value="5:00">5:00</option>
											<option value="5:30">5:30</option>
											<option value="6:00">6:00</option>
											<option value="6:30">6:30</option>
											<option value="7:00">7:00</option>
											<option value="7:30">7:30</option>
											<option value="8:00">8:00</option>
											<option value="8:30">8:30</option>
											<option value="9:00">9:00</option>
											<option value="9:30">9:30</option>
											<option value="10:00">10:00</option>
											<option value="10:30">10:30</option>
											<option value="11:00">11:00</option>
											<option value="11:30">11:30</option>
									   </select> 
									   <select name="meetingStartMeridiem" required="required" >
											<option value=""><%=meetingCalenderDTO.getMeetingStartMeridiem()%></option>
											<option value="AM">AM</option>
											<option value="PM">PM</option>
									    </select>
								 </td>    								  
							</tr>

							<tr>
								 <td><label for="meetingEndTime">End Time</label><font style="color: red">*</font></td>
								 <td>
									 <select name="meetingEndTime" required="required">
													<option value=""><%=meetingCalenderDTO.getMeetingEndTime()%></option>
													<option value="12:00">12:00</option>
													<option value="12:30">12:30</option>
													<option value="1:00">1:00</option>
													<option value="1:30">1:30</option>
													<option value="2:00">2:00</option>
													<option value="2:30">2:30</option>
													<option value="3:00">3:00</option>
													<option value="3:30">3:30</option>
													<option value="4:00">4:00</option>
													<option value="4:30">4:30</option>
													<option value="5:00">5:00</option>
													<option value="5:30">5:30</option>
													<option value="6:00">6:00</option>
													<option value="6:30">6:30</option>
													<option value="7:00">7:00</option>
													<option value="7:30">7:30</option>
													<option value="8:00">8:00</option>
													<option value="8:30">8:30</option>
													<option value="9:00">9:00</option>
													<option value="9:30">9:30</option>
													<option value="10:00">10:00</option>
													<option value="10:30">10:30</option>
													<option value="11:00">11:00</option>
													<option value="11:30">11:30</option>												
											</select> 
											<select name="meetingEndMeridiem" required="required">
													<option value=""><%=meetingCalenderDTO.getMeetingEndMeridiem()%></option>
													<option value="AM">AM</option>
													<option value="PM">PM</option>
											</select>
								 </td>  
							</tr>		   																																			

							<tr>
								 <td><label for="meetingTitle">Title</label><font style="color: red">*</font></td>
								 <td><textarea name="meetingTitle" rows="2" cols="50" required="required"><%=meetingCalenderDTO.getMeetingTitle()%></textarea></td>	    
							</tr>		  

							<tr>
								<td><label for="meetingShortDesc">Description</label></td>
								<td><textarea name="meetingShortDesc" rows="5" cols="50"><%=meetingCalenderDTO.getMeetingShortDesc()%></textarea></td>
							</tr>
								
							<tr>
								 <td><label for="meetingBranch">Branch</label><font style="color: red">*</font></td>
								 <td>
								 
								         <select name="meetingBranch" required="required">
												<option value=""><%=meetingCalenderDTO.getMeetingBranch()%></option>
												<option value="Global">Global</option>
												<option value="Kolkata">Kolkata</option>
												<option value="BTM">BTM Layout</option>
												<option value="Mahadevpura">Mahadevpura</option>
												<option value="BBS">Bhubaneswar</option>
									     </select>
								 </td>
							</tr>
								
							<tr>
								 <td><label for="meetingId">Zoom Meeting Id</label><font style="color: red">*</font></td>
								 <td><input type="text" name="meetingId" required="required" value="<%=meetingCalenderDTO.getMeetingId()%>"></td>			
							</tr>
								
							<tr>
								<td><label for="meetingPasscode">Zoom Meeting Passcode</label><font style="color: red">*</font></td>
								<td><input type="text" name="meetingPasscode" required="required" value="<%=meetingCalenderDTO.getMeetingPasscode()%>"></td>
							</tr>
								
							<tr>
								 <td><label for="zoomUrl">Zoom Meeting URL</label><font style="color: red">*</font></td>
                                 <td><input type="text" name="zoomUrl" required="required" value="<%=meetingCalenderDTO.getZoomUrl()%>"></td>
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
