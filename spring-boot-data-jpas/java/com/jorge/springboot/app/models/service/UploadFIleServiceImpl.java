package com.jorge.springboot.app.models.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadFIleServiceImpl implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private final static String UPLOADS_FOLDER = "uploads";

	@Override
	public Resource load(String filename) throws MalformedURLException {

		Path pathFoto = getPath(filename);
		log.info("pathFoto :" + pathFoto);
		Resource recurso = null;

		recurso = new UrlResource(pathFoto.toUri());

		if (!recurso.exists() && !recurso.isReadable()) {

			throw new RuntimeException("error no se  pude  cargar  la imagen" + pathFoto.toString());

		}

		return recurso;
	}

	@Override
	public String copy(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		
		String uniqueFileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		
		
		//Path directorioRecursos=Paths.get("src//main//resources//static/uploads");
		Path rootPath =getPath(uniqueFileName);//"C://Temp//uploads";//directorioRecursos.toFile().getAbsolutePath();
		
		
		log.info("rootPath :"+rootPath);
		
		
			//byte[] bytes=foto.getBytes();
			
			//Path rutaCompleta= Paths.get(rootPath+"//"+foto.getOriginalFilename());
			
			//Files.write(rutaCompleta,bytes);
			
			Files.copy(file.getInputStream(),rootPath);
			
			
		
		
		return uniqueFileName;
	}

	

	public Path getPath(String filename) {

		return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
	}

	@Override
	public boolean delete(String filename) {
		
		
		Path rootPath=getPath(filename);
		File archivo =rootPath.toFile();
		
		if(archivo.exists()&& archivo.canRead()) {
			
			
			if(archivo.delete()) {
				
				
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void deleteAll() {
FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());		
	}

	@Override
	public void init() throws IOException {
		// TODO Auto-generated method stub
		Files.createDirectory(Paths.get(UPLOADS_FOLDER));
	}

}
