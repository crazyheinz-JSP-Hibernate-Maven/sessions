
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form method='POST' action="CalculatorEL">
    ${message} <br />
    Result: ${result} <br />
    <input type='number' name='number' /><br />
    <input type='submit' name='operation' value='+' />
    <input type='submit' name='operation' value='-' />
    <input type='submit' name='operation' value='x' />
    <input type='submit' name='operation' value='/' />
    <input type='submit' name='operation' value='CE' />

    </form>
</body>
</html>
