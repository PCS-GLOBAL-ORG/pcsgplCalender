
<body bgcolor="#8ad0ff">
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
     <div align="center">
        
	<form action="/meeting-registration" method="post">

		<fieldset style="width:600px;align:center">
			<legend> Meeting Registration Window</legend>

			<table  style="align:center;width:100%" border="0">
                <tr>
                      <th colspan="2">
                           <% if (request.getAttribute("message")!=null){ %>  
                           <%=request.getAttribute("message")%>
                            <%} %>
                      </th>
                      
                </tr>   
				<tr>
					<td><label for="meetingCategory">MeetingCategory </label>
					   <font style="color:red">*</font>     
					</td>
					<td><select name="meetingCategory" required="required">
							<option value="">Select</option>
							<option value="Global">Global</option>
							<option value="Kolkata">Kolkata</option>
							<option value="BTM">BTM Layout</option>
							<option value="Mahadevpura">Mahadevpura</option>
					        <option value="BBS">Bhubaneswar</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="meetingOccuranceType">Recurring Meeting</label></td>
					<td>
					<input type="radio" id="yes" name="meetingOccuranceType"
						value="M" >   <label for="yes">Yes</label>   <input
						type="radio" id="no" name="meetingOccuranceType" value="S">
						  <label for="no">No</label></td>
				</tr>

				<tr>
					<td><label for="meetingStartDate">Meeting Start Date</label>
					    <font style="color:red">*</font> 
					</td>
					<td><input type="date" pattern="yyyy-MM-dd"
						name="meetingStartDate" required="required"></td>

				</tr>


				<tr>
					<td><label for="meetingEndDate">Meeting End Date</label></td>
					<td><input type="date" pattern="yyyy-MM-dd"
						name="meetingEndDate"></td>

				</tr>

				<tr>
					<td><label for="meetingStartTime">Meeting Start Time</label></td>
					<td>
					
					<select name="meetingStartTime">
							<option value="">Select</option>
							<option value="12:00">12:00</option>
							<option value="12:30">12:30</option>
							<option value="1:00">1:00</option>
							<option value="1:30">1:30</option>
					</select>
					<select name="meetingStartMeridiem">
							<option value="">Select</option>
							<option value="AM">AM</option>
							<option value="PM">PM</option>							
					</select>
					</td>

				</tr>

				<tr>
					<td><label for="meetingEndTime">Meeting End Time</label></td>
					<td>
					     <select name="meetingEndTime">
							<option value="">Select</option>
							<option value="12:00">12:00</option>
							<option value="12:30">12:30</option>
							<option value="1:00">1:00</option>
							<option value="1:30">1:30</option>
					</select> 
					<select name="meetingEndMeridiem">
							<option value="">Select</option>
							<option value="AM">AM</option>
							<option value="PM">PM</option>							
					</select>
					
					</td>

				</tr>

				<tr>
					<td><label for="meetingTitle">Meeting Title</label></td>
					<td><textarea  name="meetingTitle" rows="2" cols="50"> </textarea>				
					</td>

				</tr>

				<tr>
					<td><label for="meetingShortDesc">Meeting Description</label></td>
					<td><textarea  name="meetingShortDesc" rows="5" cols="50"></textarea>
					</td>

				</tr>
				<tr>
					<td><label for="meetingBranch">Meeting Branch</label></td>
					<td><select name="meetingBranch">
							<option value="">Select</option>
							<option value="Global">Global</option>
							<option value="Kolkata">Kolkata</option>
							<option value="BTM">BTM Layout</option>
							<option value="Mahadevpura">Mahadevpura</option>
					        <option value="BBS">Bhubaneswar</option>
					</select>
					</td>
				</tr>
				<tr>
					<td><label for="meetingId">Zoom Meeting Id</label></td>
					<td><input type="text" name="meetingId"></td>

				</tr>
				<tr>
					<td><label for="meetingPasscode">Zoom Meeting Passcode</label></td>
					<td><input type="text" name="meetingPasscode"></td>

				</tr>
				<tr>
					<td><label for="zoomUrl">Zoom Meeting URL</label></td>
					<td><input type="text" name="zoomUrl"></td>

				</tr>
				<tr>
					<td>
						&nbsp;
			       </td>
                   <td> <input type="submit" name="submit" value="Submit"/> &nbsp;
						<input type="reset" name="Reset" value="Reset"/>
					</td>
                      
				</tr>

			</table>
		</fieldset>
	</form>
	</div>
	<%@include file="footer.jsp" %>
</body>
