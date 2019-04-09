<template>
	<view class="content">
		<view class="box"><input type="text" class="phone" placeholder="请输入手机号" /></view>
		<view class="box"><input type="text" class="code" placeholder="请输入短信验证码" />
			<button class="accept">获取</button>
		</view>
		<navigator url="../register_psd/register_psd" class="register"><button class="rightnow">下一步</button></navigator>
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
    .code{
		flex: 1 1 70%;
	}
	.box {
		margin-top: 40upx;
		height:120upx;
		display: flex;
		align-items: center;
		border-bottom: 1px solid #D3D3D3;
	}

	.accept {
		height:100upx;
		flex: 1 1 30%;
		display: flex;
		justify-content: center;
		align-items: center;
		background-color: #19AD1A;
		color: #EEEEEE;
	}

	.rightnow {
		margin-top: 30upx;
		background-color: #2E7BEB;
		color: #EEEEEE;
	}
</style>
