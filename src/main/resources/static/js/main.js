// 提交评论
function post(id,type,content) {
    if (!content) {
        alert("评论内容不能为空！");
        return;
    }
    $.ajax({
        url: "/comment",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": id,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    let confirm = window.confirm("未登录，请先登录！");
                    if (confirm) {
                        window.open("https://github.com/login/oauth/authorize?client_id=2dee127350ab978c4543&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
};
function comment(e) {
    var questionId = $("#questionId").val();
    var content = $("#comment_content").val();
    post(questionId,1,content);
}
function reply(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#reply-"+commentId).val();
    post(commentId,2,content);
}

//显示二级评论
function collapseComment(e) {
    let id = e.getAttribute("data-id");
    let comment = $("#comment-" + id);
    let collapse = e.getAttribute("data-collapse");
    if (collapse) {
        comment.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        $.getJSON(
            "/comment/"+id,function (data) {
                console.log(data);
                let commentBody = $("#comment-body-"+id);
                commentBody.appendChild();


                $.each(data.data, function (key,value) {

                })
                comment.addClass("in");
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            }

        )
    }
};