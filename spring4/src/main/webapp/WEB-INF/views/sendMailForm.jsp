<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>sendMailForm.jsp</h3>
	<form action="<%=request.getContextPath()%>/sendEmailProc" method="post">
		<table border="1">
			<tbody>
				<tr>
					<th>(받는 사람) 메일주소</th>
					<td><input type="text" name="address" id="adress" placeholder="example@example.com"></td>
				</tr>
				<tr>
					<th>(subject)메일 제목</th>
					<td><input type="text" name="subject" id="subject" placeholder="제목을 입력하세요."></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="content" rows="40" cols="100" placeholder="내용을 입력하세요."></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="eamil보내기">
					<input type="reset" value="취소">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>