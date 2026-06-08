package com.goodseva.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

/**
 * VideoRecoderUtil - provides videorecording start and stop methods, generates the video file in avi format
 *
 */
public class VideoRecoderUtil extends ScreenRecorder {

    public static Logger log = LogManager.getLogger();
    public static ScreenRecorder screenRecorder;
    public String name;

    /**
     * @param cfg
     * @param captureArea
     * @param fileFormat
     * @param screenFormat
     * @param mouseFormat
     * @param audioFormat
     * @param movieFolder
     * @param name
     * @throws AWTException
     * @throws IOException
     */
    public VideoRecoderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                            Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws AWTException, IOException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    /**
     * @param scenarioName
     * @throws AWTException
     * @throws IOException
     */
    public static void startRecord(String scenarioName) {
        try {
            String filepath = System.getProperty("user.dir")+"/Execution Videos/";
            File file = new File(filepath);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;
            Rectangle captureSize = new Rectangle(0, 0, width, height);
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                    getDefaultScreenDevice()
                    .getDefaultConfiguration();
            screenRecorder = new VideoRecoderUtil(gc, captureSize,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                            Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null, file, scenarioName);
            screenRecorder.start();
        } catch (AWTException | IOException e) {
            log.error("Failure in start record of Video Recorder Util " + e.getMessage());
        }
    }

    /**
     * @throws InterruptedException
     * @throws IOException
     */
    public static void stopRecord() {
        try {
            TimeUnit.SECONDS.sleep(3);
            screenRecorder.stop();
        } catch (InterruptedException | IOException e) {
            log.error("Failure in stop record of Video Recorder Util " + e.getMessage());
        }
    }

    /**
     * @param fileFormat
     * @return
     * @throws IOException
     */
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH.mm.ss");
        return new File(movieFolder,
                name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }


}