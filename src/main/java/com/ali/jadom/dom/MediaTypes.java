package com.ali.jadom.dom;

public   enum MediaTypes{
	ALL/*" Suitable for all devices.")*/,
    AURAL/* Intended for speech synthesizers. See the section on aural style sheets for details.*/, 
    BRAILLE/*braille  Intended for braille tactile feedback devices.*/ ,
    EMBASSED/* Intended for paged braille printers. */,
    HANDHELD /*Intended for handheld devices (typically small screen, monochrome, limited bandwidth). */,
    PRINT /* Intended for paged, opaque material and for documents viewed on screen in print preview mode.*/,
	PROJECTION/* Intended for projected presentations, for example projectors or print to transparencies. Please consult the section on paged media for information about formatting issues that are specific to paged media.*/, 
	SCREEN/*  Intended primarily for color computer screens. */,
	TTY/*   Intended for media using a fixed-pitch character grid, such as teletypes, terminals, or portable devices with limited display capabilities. Authors should not use pixel units with the "tty" media type. */,
	TV /*   Intended for television-type devices (low resolution, color, limited-scrollability screens, sound available). */
	,NULL
}