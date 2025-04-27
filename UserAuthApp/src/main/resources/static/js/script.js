document.getElementById("registerForm").addEventListener("submit", function(event) {
	event.preventDefault(); // フォームのデフォルトの送信をキャンセル

	const name = document.getElementById("name").value;
	const email = document.getElementById("email").value;
	const password = document.getElementById("password").value;

	const user = { name, email, password };

	fetch("/api/auth/register", {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(user)
	})
		.then(async response => {
			const isJson = response.headers.get("content-type")?.includes("application/json");
			const data = isJson ? await response.json() : null;

			if (!response.ok) {
				const message = data?.message || "エラーが発生しました。";
				throw new Error(message);
			}

			document.getElementById("result").innerText = data?.message || "登録成功！";
		})
		.catch(error => {
			document.getElementById("result").innerText = error.message || "エラーが発生しました。";
			console.error("エラー内容:", error);
		});
});