<template>
	<div class="container">
		<h2>班课详情页面</h2>
		<div class="counter">
			<img :src="course.cover" class="course-cover">
		<p class="title">{{course.courseClass}}</p>
		<p class="title">{{course.courseName}}</p>
		</div>
		<button type="button" @click="addCourse(course)" class="btn">结束班课</button>
		
	</div>
</template>

<script>
export default {
	name: 'CourseDetail',
	data() {
		return {
			id: this.$route.params.id,
			course: {}
		};
	},
	methods: {
		addCourse: function(course) {
			var _this = this;
			this.$http({
				method: 'put',
				url: 'http://localhost:8080/api/course',
				data: {
					userId: _this.loginUserId,
					courseName: course.courseName,
					courseClass: course.courseClass,
					courseId: _this.id,
					cover: course.cover,
					finished: 1
				}
			}).then(function() {
				alert('修改成功');
				_this.$router.push('/');
			});
		}
	},
	created() {
		var _this = this;
		this.$http.get('http://localhost:8080/api/course/' + this.id).then(function(response) {
			_this.course = response.data;
		});
	}
};
</script>
<style scoped>
	.counter {
		width: 260px;
		height: 420px;
		margin-right: 20px;
		margin-bottom: 30px;
		background-color: #fff;
		display: flex;
		flex-direction: column;
		padding-bottom: 10px;
	}
	.course-cover  {
		width: 100%;
		height: 280px;
	}
	.btn {
		width: 120px;
		height: 40px;
		border: 1px solid #fff;
		background-color: rgb(0, 187, 221);
		border-radius: 20px;
		outline: none;
		color: #fff;
		font-size: 16px;
	}
	.title {
		font-size: 16px;
		color: #333;
	}
</style>