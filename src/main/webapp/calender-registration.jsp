
<%@page import="com.pcsgpl.tc.dto.OfficeLocationsDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcsgpl.tc.dto.MeetingCalenderDTO"%>
<body>

	<%@include file="header.jsp"%>
	<%@include file="navbar.jsp"%>
	<div align="center">

		<form action="/meeting-registration" method="post">

			<fieldset style="width: 600px; align: center">
				<legend> Meeting Registration Window</legend>
				       <table style="align: center; width: 100%" border="0">
					        <tr>
						        <th colspan="2">
							       <%
							         if (request.getAttribute("message") != null) {
							         %> <%=request.getAttribute("message")%> <% }
							        %>
						         </th>
					        </tr>
					        
					        <tr>
						       <td>
						           <label for="meetingCategory">MeetingCategory </label> 
						           <font style="color: red">*</font>
						        </td>
						        <td>
							       <%
						         
						            List<OfficeLocationsDTO> officeLocDtos = (List<OfficeLocationsDTO>) request.getAttribute("officeLocDtos");
						             %>
						                <select name="meetingCategory" required="required" >
						                       	<option value="">Select</option>
						                     <% for(OfficeLocationsDTO officeLocationsDTO:officeLocDtos){ 
							                   %> 							                    	
												   <option value="<%=officeLocationsDTO.getBranchCode()%>"><%=officeLocationsDTO.getBranchName()%></option>
											<%} %>
						             </select>     
							     </td>
					         </tr>
					         
					         <tr>
						         <td>
						            <label for="meetingOccuranceType">Recurring Meeting</label>
						            <font style="color: red">*</font>
						         </td>
						         <td>
						             <input type="radio" id="yes" name="meetingOccuranceType" value="M">  
						             <label for="yes">Yes</label>   
						             <input type="radio" id="no" name="meetingOccuranceType" value="S">
							         <label for="no">No</label>
							     </td>
					          </tr>

							  <tr>
								  <td>
								      <label for="meetingStartDate">Meeting Start Date</label>
									  <font style="color: red">*</font>
								  </td>
								  <td>
								     <input type="date" pattern="yyyy-MM-dd" name="meetingStartDate" required="required">
								  </td>
							  </tr>

							  <tr>
								<td>
								    <label for="meetingEndDate">Meeting End Date</label>
								    <font style="color: red">*</font>
								</td>
								<td>
								   <input type="date" pattern="yyyy-MM-dd" name="meetingEndDate" required="required">
								</td>
							  </tr>

							  <tr>
								  <td>
								     <label for="meetingStartTime">Meeting Start Time</label>
								     <font style="color: red">*</font>
								  </td>
								  <td>
								      <select name="meetingStartTime" required="required">
											<option value="">Select</option>
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
											<option value="">Select</option>
											<option value="AM">AM</option>
											<option value="PM">PM</option>
									    </select>
								     </td>
							     </tr>

								<tr>
									<td>
									   <label for="meetingEndTime">Meeting End Time</label>
									   <font style="color: red">*</font>
									</td>
									<td>
										<select name="meetingEndTime" required="required">
												<option value="">Select</option>
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
												<option value="">Select</option>
												<option value="AM">AM</option>
												<option value="PM">PM</option>
										</select>
									</td>
								</tr>

								<tr>
									<td>
									    <label for="meetingTitle">Meeting Title</label>
									    <font style="color: red">*</font>
									</td>
									<td>
									   <textarea name="meetingTitle" rows="2" cols="50" required="required"> </textarea>
									</td>
								</tr>

								<tr>
									<td><label for="meetingShortDesc">Meeting Description</label></td>
									<td><textarea name="meetingShortDesc" rows="5" cols="50"></textarea></td>
								</tr>
								
								<tr>
									<td>
									    <label for="meetingBranch">Meeting Branch</label>
									    <font style="color: red">*</font>
									</td>
									<td>
									 
                                <%
						         
						            List<OfficeLocationsDTO> officeLocDtos1 = (List<OfficeLocationsDTO>) request.getAttribute("officeLocDtos");
						             %>
						             <select name="meetingBranch" >
						                    <option value="">- : Select Branch :-</option>
						                     <% for(OfficeLocationsDTO officeLocationsDTO:officeLocDtos1){ 
							                    %> 
							                   <option value="<%=officeLocationsDTO.getBranchCode()%>" ><%=officeLocationsDTO.getBranchName()%></option>
						                  <%}%>
						             </select>     
									 </td>
								</tr>
								
								<tr>
									<td>
									    <label for="meetingId">Zoom Meeting Id</label>
									    <font style="color: red">*</font>
									</td>
									<td><input type="text" name="meetingId" required="required"></td>			
								</tr>
								
								<tr>
									<td>
									    <label for="meetingPasscode">Zoom Meeting Passcode</label>
									    <font style="color: red">*</font>
									</td>
									<td><input type="text" name="meetingPasscode" required="required"></td>
								</tr>
								
								<tr>
									<td>
									    <label for="zoomUrl">Zoom Meeting URL</label>
									    <font style="color: red">*</font>
									</td>
									<td><input type="text" name="zoomUrl" required="required"></td>
								</tr>
								
								<tr>
									<td>&nbsp;</td>
									<td><input type="submit" name="submit" value="Submit" />
										&nbsp; <input type="reset" name="Reset" value="Reset" />
									</td>
								</tr>
				  </table>
			</fieldset>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
