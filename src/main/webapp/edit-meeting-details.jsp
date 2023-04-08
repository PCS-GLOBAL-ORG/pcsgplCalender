
<%@page import="com.pcsgpl.tc.service.MeetingCalenderService"%>
<%@page import="com.pcsgpl.tc.dto.OfficeLocationsDTO"%>
<%@page import="com.pcsgpl.tc.dto.MeetingCalenderDTO"%>
<%@page import="com.pcsgpl.tc.util.MeetingCalenderUtil"%>
<%@page import="java.util.List,java.util.ArrayList"%>
<body >

	<%@include file="header.jsp"%>
	<%@include file="navbar.jsp"%>
	<div align="center">
		<form action="/update-meeting" method="post">
			<fieldset style="width: 600px; align: center">
				<legend> Meeting Update Information Window</legend>				
				     <%	
				    
				         if(request.getAttribute("calender_info_by_meeting_id")!=null){				        	 
				        	 MeetingCalenderDTO  meetingCalenderDTO  =(MeetingCalenderDTO) request.getAttribute("calender_info_by_meeting_id");				        	 				        	 
				      %>
				      			        	  				        													
				      <table style="align: center; width: 100%" border="0">
					  					        
					        <tr>
					             <td><label for="meetingCategory">Category </label><font style="color: red">*</font></td>
						         <td>
						             <%
						         
						            List<OfficeLocationsDTO> officeLocDtos = (List<OfficeLocationsDTO>) request.getAttribute("officeLocDtos");
						             %>
						             <select name="meetingCategory" >
						                     <% for(OfficeLocationsDTO officeLocationsDTO:officeLocDtos){ 
							                     if((officeLocationsDTO.getBranchName()).equals(meetingCalenderDTO.getMeetingCategory())){  %>
							                       <option value="<%=officeLocationsDTO.getBranchName()%>" selected="selected"><%=officeLocationsDTO.getBranchName()%></option>
												  <%} %>
												   <option value="<%=officeLocationsDTO.getBranchName()%>"><%=officeLocationsDTO.getBranchName()%></option>
											<%} %>
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
								        <input type="radio" name="meetingOccuranceType" value="M" checked="checked"/> Multiple
								        <input type="radio" name="meetingOccuranceType" value="S"/> Single
								      <%}else if(meetingCalenderDTO.getMeetingOccuranceType().equals("Single")){ %>	
								        <input type="radio" name="meetingOccuranceType" value="M"/> Multiple		
								        <input type="radio" name="meetingOccuranceType" value="S" checked="checked"/> Single 
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
								    
								    <select name="meetingStartTime" >
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
									   <select name="meetingStartMeridiem"  >
											<option value=""><%=meetingCalenderDTO.getMeetingStartMeridiem()%></option>
											<option value="AM">AM</option>
											<option value="PM">PM</option>
									    </select>
								 </td>    								  
							</tr>

							<tr>
								 <td><label for="meetingEndTime">End Time</label><font style="color: red">*</font></td>
								 <td>
									 <select name="meetingEndTime">
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
											<select name="meetingEndMeridiem">
													<option value=""><%=meetingCalenderDTO.getMeetingEndMeridiem()%></option>
													<option value="AM">AM</option>
													<option value="PM">PM</option>
											</select>
								 </td>  
							</tr>		   																																			

							<tr>
								 <td><label for="meetingTitle">Title</label><font style="color: red">*</font></td>
								 <td><textarea name="meetingTitle" rows="2" cols="50"><%=meetingCalenderDTO.getMeetingTitle()%></textarea></td>	    
							</tr>	 	  

							<tr>
								<td><label for="meetingShortDesc">Description</label></td>
								<td><textarea name="meetingShortDesc" rows="5" cols="50"><%=meetingCalenderDTO.getMeetingShortDesc()%></textarea></td>
							</tr>
								
							<tr>
								 <td><label for="meetingBranch">Branch</label><font style="color: red">*</font></td>
								 <td>
								 
			
												<%
						         
						            List<OfficeLocationsDTO> officeLocDtos1 = (List<OfficeLocationsDTO>) request.getAttribute("officeLocDtos");
						             %>
						             <select name="meetingBranch" >
						                     <% for(OfficeLocationsDTO officeLocationsDTO:officeLocDtos1){ 
							                     if((officeLocationsDTO.getBranchName()).equals(meetingCalenderDTO.getMeetingCategory())){  %>
							                       <option value="<%=officeLocationsDTO.getBranchCode()%>" selected="selected"><%=officeLocationsDTO.getBranchName()%></option>
												  <%} %>
												   <option value="<%=officeLocationsDTO.getBranchCode()%>"><%=officeLocationsDTO.getBranchName()%></option>
											<%} %>
						             </select>     
								 </td>
							</tr>
								
							<tr>
								 <td><label for="meetingId">Zoom Meeting Id</label><font style="color: red">*</font></td>
								 <td><input type="text" name="meetingId" readonly  value="<%=meetingCalenderDTO.getMeetingId()%>"></td>			
							</tr>
								
							<tr>
								<td><label for="meetingPasscode">Zoom Meeting Passcode</label><font style="color: red">*</font></td>
								<td><input type="text" name="meetingPasscode" readonly  value="<%=meetingCalenderDTO.getMeetingPasscode()%>"></td>
							</tr>
								
							<tr>
								 <td><label for="zoomUrl">Zoom Meeting URL</label><font style="color: red">*</font></td>
                                 <td><input type="text" name="zoomUrl" readonly  value="<%=meetingCalenderDTO.getZoomUrl()%>"></td>
						    </tr>
						    
								<tr>
									<td>&nbsp;</td>
									<td><input type="submit" name="submit" value="Update" />
									</td>
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
