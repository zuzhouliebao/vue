<template>
	<view class="content">
		<view class="box"><input type="text" class="password" placeholder="请输入密码" /></view>
	<navigator class="register" url="../signin/signin"><button class="rightnow">立即注册</button></navigator>
	</view>
</template>

<script>
	export default {
		data() {
			return {
	
			};
		},
		onLoad() {
	
		},
		onShow() {
	
		},
		methods: {
	
		}
	}
</script>

<style scoped="scoped">
	.content {
		width: 90%;
		margin: 0 auto;
		display: flex;
		flex-direction: column;
		margin-top: 20upx;
	}
	.rightnow {
		margin-top: 30upx;
		background-color: #2E7BEB;
		color: #EEEEEE;
	}
</style>
