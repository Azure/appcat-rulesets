import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;
import software.amazon.awssdk.transfer.s3.S3TransferManager;
import software.amazon.awssdk.transfer.s3.model.DownloadFileRequest;
import software.amazon.awssdk.transfer.s3.model.UploadFileRequest;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;

public class S3BlobExample {
    public static void main(String[] args) throws Exception {
        // AWS SDK v2 - Specify the AWS region and bucket details
        Region region = Region.US_WEST_2;
        String bucketName = "your-bucket-name";
        String objectKey = "your-object-key";
        String localFilePath = "path/to/your/file";
        String downloadFilePath = "path/to/downloaded/file";

        // AWS SDK v2 - Create an S3 client
        S3Client s3Client = S3Client.builder()
                .region(region)
                .build();

        // AWS SDK v2 - Create an S3 presigner
        S3Presigner presigner = S3Presigner.builder()
                .region(region)
                .build();

        // AWS SDK v2 - Create a GetObjectRequest
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        // AWS SDK v2 - Generate the presigned URL
        PresignedGetObjectRequest presignedGetObjectRequest = presigner.presignGetObject(getObjectRequest,
                Duration.ofMinutes(10));
        URL presignedUrl = presignedGetObjectRequest.url();
        System.out.println("Presigned URL: " + presignedUrl);

        // AWS SDK v2 - Create an S3 Transfer Manager
        S3TransferManager transferManagerV2 = S3TransferManager.builder()
                .s3Client(s3Client)
                .build();

        // AWS SDK v2 - Upload a file using Transfer Manager
        UploadFileRequest uploadFileRequestV2 = UploadFileRequest.builder()
                .source(Paths.get(localFilePath))
                .destinationBucket(bucketName)
                .destinationKey(objectKey)
                .build();
        transferManagerV2.uploadFile(uploadFileRequestV2).completionFuture().join();
        System.out.println("File uploaded successfully with AWS SDK v2.");

        // AWS SDK v2 - Download a file using Transfer Manager
        DownloadFileRequest downloadFileRequestV2 = DownloadFileRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .destination(Paths.get(downloadFilePath))
                .build();
        transferManagerV2.downloadFile(downloadFileRequestV2).completionFuture().join();
        System.out.println("File downloaded successfully with AWS SDK v2.");

        // Close the AWS SDK v2 presigner and client
        presigner.close();
        s3Client.close();

        // AWS SDK v1 - Create an S3 client
        AmazonS3 s3ClientV1 = AmazonS3ClientBuilder.standard()
                .withRegion(region.getName())
                .withCredentials(new ProfileCredentialsProvider())
                .build();

        // AWS SDK v1 - Generate a presigned URL
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, objectKey);
        generatePresignedUrlRequest.setExpiration(new java.util.Date(System.currentTimeMillis() + 3600000)); // 1 hour
        URL presignedUrlV1 = s3ClientV1.generatePresignedUrl(generatePresignedUrlRequest);
        System.out.println("Presigned URL (AWS SDK v1): " + presignedUrlV1);

        // AWS SDK v1 - Create a Transfer Manager
        TransferManager transferManagerV1 = TransferManagerBuilder.standard()
                .withS3Client(s3ClientV1)
                .build();

        // AWS SDK v1 - Upload a file using Transfer Manager
        Upload upload = transferManagerV1.upload(bucketName, objectKey, new File(localFilePath));
        upload.waitForCompletion();
        System.out.println("File uploaded successfully with AWS SDK v1.");

        // AWS SDK v1 - Download a file using Transfer Manager
        Download download = transferManagerV1.download(bucketName, objectKey, new File(downloadFilePath));
        download.waitForCompletion();
        System.out.println("File downloaded successfully with AWS SDK v1.");

        // Shutdown the AWS SDK v1 Transfer Manager
        transferManagerV1.shutdownNow();
    }
}
