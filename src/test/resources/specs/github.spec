# вот тут объекты
# имя_переменной    стратегия_поиска    значение

@objects
    signin_btn  css     .btn-primary
    signin_form css     .auth-form-body
    login_label css     label[for=login_field]

= Main section =
    @on desktop
        signin_btn:
            css background-color is "rgba(35, 134, 54, 1)"
            width 274px

        signin_form:
            image file images/form.png, error 1%

        login_label:
            text is "Username or email address!"
