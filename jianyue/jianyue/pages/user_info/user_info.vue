<template>
	<view class="content">
         <view class="box nickname">昵称:<input type="text" class="text" v-model="nickname"/></view>
		 <view class="box per-avatar">个人头像:<image :src="avatar" class="avatar" @tap="showActionSheet"></image></view>
		 <view class="box">修改密码:</view>
		 <navigator url="../my/my" class="nav" open-type="navigateBack" delta="2">确定修改</navigator>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				nickname:'',
				avatar:'',
				userId: uni.getStorageSync('login_key').userId
			};
		},
		onLoad() {

		},
		onShow() {
			var _this=this;
			uni.request({
				url: 'http://localhost:8080/api/user/avatar/' + uni.getStorageSync('login_key').userId,
				method: 'GET',
				header: { 'content-type': 'application/json' },
				success: res => {
					if (res.data.code === 0) {
						console.log(res.data.data);
						_this.avatar = res.data.data.avatar;
						_this.nickname = res.data.data.nickname;
					}
				}
			});
		},
		methods: {
			showActionSheet: function() {
				console.log('show');
				var _this = this;
				uni.showActionSheet({
					itemList: ['拍照', '从相册选择'],
					success: function(res) {
						console.log('选中了第' + (res.tapIndex + 1) + '个按钮');
						//选择的是拍照功能
						if (res.tapIndex == 0) {
							uni.chooseImage({
								count: 1,
								sourceType: ['camera'],
								success: function(res) {
									uni.saveImageToPhotosAlbum({
										filePath: res.tempFilePaths[0],
										success: function() {
											console.log('save success');
											uni.uploadFile({
												url: 'http://localhost:8080/api/user/avatar',
												filePath: res.tempFilePaths[0],
												name: 'file',
												formData: {
													id: _this.userId
												},
												success: uploadFileRes => {
													console.log(uploadFileRes.data);
													_this.avatar = uploadFileRes.data;
													_this.nickname=uploadFileRes.data;
												},
											});
										}
									});
								}
							});
						}
						//从相册选择
						if (res.tapIndex == 1) {
							uni.chooseImage({
								count: 1, //默认9
								sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都
								sourceType: ['album'], //从相册选择
								success: function(res) {
									console.log(JSON.stringify(res.tempFilePaths));
									uni.uploadFile({
										url: 'http://localhost:8080/api/user/avatar',
										filePath: res.tempFilePaths[0],
										name: 'file',
										formData: {
											id: _this.userId
										},
										success: uploadFileRes => {
											console.log(uploadFileRes.data);
											_this.avatar = uploadFileRes.data;
											_this.nickname=uploadFileRes.data;
										}
									});
								}
							});
						}
					},
					fail: function(res) {
						console.log(res.errMsg);
					}
				});
			}
		}
	}
</script>

<style scoped="scoped">
	.nav{
		width: 95%;
		height: 80upx;
		background-color: #19ad1a;
		display: flex;
		border-radius: 10upx;
		margin-left: 15upx;
		color:#eee;
		justify-content: center;
		align-items: center;
		justify-content: center;
	}
	.text{
		width:100upx;
		border: 1px solid #D3D3D3;
	}
	.content{
		display: flex;
		flex-direction: column;
	}
	.box{
		width:90%;
		height:120upx ;
		margin: 0 auto;
		display: flex;
		align-items: center;
		justify-content: space-between;
	}
	.avatar{
		border-radius: 50%;
		width: 100upx;
		height: 100upx;
	}
</style>
