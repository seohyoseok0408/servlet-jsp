<%
    int x = 3;
    int y = 4;
    int page = 3;
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        input {
            width: 50px;
            height: 50px;
        }
        .output {
            width: 200px;
            height: 50px;
            background: #e9e9e9;
            font-size:24px;
            font-weight: bold;
            text-align: right;
            padding: 0px 5px;
        }
    </style>
</head>
<body>
    <form action="calc3" method="get">
        <table>
            <tr>
                <td class="output" colspan="4">${x+y}</td>
            </tr>
            <tr>
                <td><input type="submit" name="operator" value="CE"/></td>
                <td><input type="submit" name="operator" value="C"/></td>
                <td><input type="submit" name="operator" value="BS"/></td>
                <td><input type="submit" name="operator" value="÷"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="value" value="7"/></td>
                <td><input type="submit" name="value" value="8"/></td>
                <td><input type="submit" name="value" value="9"/></td>
                <td><input type="submit" name="operator" value="X"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="value" value="4"/></td>
                <td><input type="submit" name="value" value="5"/></td>
                <td><input type="submit" name="value" value="6"/></td>
                <td><input type="submit" name="operator" value="-"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="value" value="1"/></td>
                <td><input type="submit" name="value" value="2"/></td>
                <td><input type="submit" name="value" value="3"/></td>
                <td><input type="submit" name="operator" value="+"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="value" value="0"/></td>
                <td><input type="submit" name="dot" value="."/></td>
                <td><input type="submit" name="operator" value="="/></td>
            </tr>
        </table>
    </form>
</body>
</html>