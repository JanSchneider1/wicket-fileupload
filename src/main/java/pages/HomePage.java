package pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

    public HomePage(final PageParameters parameters) {
        super(parameters);
        add(new Label("text", "Hello World"));

        // Create form
        Form<Void> uploadForm = new Form<Void>("uploadForm") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                System.out.println("Upload-Form submitted!");
            }
        };

        // Create upload field
        FileUploadField uploadField = new FileUploadField("fileUpload");
        uploadField.add(new AjaxFormSubmitBehavior("change") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);
                FileUpload fileUpload = uploadField.getFileUpload();
                System.out.println(fileUpload.getClientFileName());
            }
        });
        uploadForm.add(uploadField);

        // Create upload process bar
        uploadForm.add(new UploadProgressBar("progress", uploadForm, uploadField));

        add(uploadForm);
    }
}