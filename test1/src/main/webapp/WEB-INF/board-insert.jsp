<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <style>
		table, tr, th, td {
			border : 1px solid black;
		}
		
		
		
    </style>
</head>
<body>
<div id="app">
	{{list}}
</div>

<script>
    const app = Vue.createApp({
        data() {
            return {
                name : "홍길동",
				
            };
        },
        methods: {
            fnGetList(){
				var self = this;
                $.ajax({
					url:"board-list.dox",
					dataType:"json",	
					type : "POST", 
					data : nparmap,
					success : function(data) { 
						console.log(data);
						alert(data.message);
						self.list = data.list;
						//self.info = data.stu;
                });
            }
        },
        mounted() {
            
        }
    });
    app.mount('#app');
</script>
</body>
</html>